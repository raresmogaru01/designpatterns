
package org.example.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final List<Observer> observers;

    public void notifyObservers(String message) {
        observers.forEach(o -> o.update(message));
    }
}
