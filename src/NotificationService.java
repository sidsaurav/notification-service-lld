import entities.User;
import enums.NotificationType;
import factory.NotificationStrategyFactory;
import strategies.EmailStrategy;
import strategies.NotificationStrategy;
import strategies.PushStrategy;
import strategies.SMSStrategy;

import java.util.*;

public class NotificationService {

    Map<String, List<NotificationType>> notificationMap;
    Map<String, User> users = new HashMap<>();
    NotificationService () {
        notificationMap = new HashMap<>();
    }

    public void addUser(String name, String userId) {
        users.put(userId, new User(name, userId));
        System.out.println("User added");
    }

    public void subscribe(String userId, NotificationType type) {
        notificationMap.putIfAbsent(userId, new ArrayList<>());
        notificationMap.get(userId).add(type);

        System.out.println(type + " added to " + userId + " subscription");
    }

    public void unsubscribe(String userId, NotificationType type) {
        if(notificationMap.containsKey(userId)) {
            notificationMap.get(userId).remove(type);
        }

        System.out.println(type + " removed from " + userId + " subscription");
    }

    public List<NotificationType> listSubscriptions(String userId) {
        return notificationMap.getOrDefault(userId, new ArrayList<>());
    }

    public void publishNotification(NotificationType notificationType, String message) {
        for (var userId : notificationMap.keySet()) {
            if (notificationMap.get(userId).contains(notificationType)) {
                NotificationStrategy ntf = NotificationStrategyFactory.getStrategy(notificationType);
                ntf.sendNotification(message);
            }
        }

        System.out.println("Notification published");
    }
}


