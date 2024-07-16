package factory;

import enums.NotificationType;
import strategies.EmailStrategy;
import strategies.NotificationStrategy;
import strategies.PushStrategy;
import strategies.SMSStrategy;

public class NotificationStrategyFactory {
    public static NotificationStrategy getStrategy(NotificationType type) {
        switch(type){
            case NotificationType.EMAIL:
                return new EmailStrategy();

            case NotificationType.SMS:
                return new SMSStrategy();

            case NotificationType.PUSH:
                return new PushStrategy();
        }

        return new EmailStrategy();
    }
}
