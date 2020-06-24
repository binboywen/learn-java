interface IMessage {
    public void send(String str);
}
class MessageImpl implements IMessage {
    public void send(String str) {
        System.out.println("SEND: " + str);
    }
}
interface IChannel {
    public void connect();
}

class ChannelImpl implements IChannel {
    public void connect() {
        System.out.println("CONNECTED");
    }
}
class Factory {
    static <T> T getInstance(String className) {
        if ("messageImpl".equalsIgnoreCase(className)) {
            return (T)new MessageImpl();
        }
        else if ("channelImpl".equalsIgnoreCase(className)) {
            return (T)new ChannelImpl();
        }
        return null;
    }
}
public class Template {
    public static void main(String args[]) {
        IMessage msg = Factory.getInstance("messageImpl");
        msg.send("www.mldn.cn");
        IChannel chn = Factory.getInstance("channelImpl");
        chn.connect();
    }
}