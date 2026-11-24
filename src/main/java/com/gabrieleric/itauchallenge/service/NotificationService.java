package com.gabrieleric.itauchallenge.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gabrieleric.itauchallenge.dto.NotificationDTO;
import com.gabrieleric.itauchallenge.models.NotificationModel;
import com.gabrieleric.itauchallenge.repository.NotificationRepository;

@Service 
public class NotificationService {

    private final NotificationRepository repository;
    private final Map<String, NotificationSender> sendersByChannel;

    public NotificationService(NotificationRepository repository, List<NotificationSender> senders) {
        this.repository = repository;
        this.sendersByChannel = senders.stream()
                .collect(Collectors.toMap(
                        sender -> sender.getChannel().toLowerCase(),
                        sender -> sender
                ));
    }
    
    public NotificationDTO sendNotification(NotificationDTO data){
        NotificationModel model = new NotificationModel(data.getId(), data.getMessage(), data.getRecipient(), data.getChannel());
        NotificationSender sender = sendersByChannel.get(data.getChannel());
        sender.send(data.getMessage(), data.getRecipient());
        repository.save(model);
        return data;
    }

    public NotificationDTO getDTOById(Long id) {
        if (id == null){
            return new NotificationDTO();
        }
        return repository.findById(id)
            .map(this::toDTO) // ou model -> new NotificationDTO(model)
            .orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));
    }
    private NotificationDTO toDTO(NotificationModel model) {
    NotificationDTO dto = new NotificationDTO();
    dto.setId(model.getId());
    dto.setMessage(model.getMessage());
    dto.setChannel(model.getChannel());
    dto.setRecipient(model.getRecipient());
    return dto;
}
}
