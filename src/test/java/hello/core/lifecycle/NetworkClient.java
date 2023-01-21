package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient
//        implements InitializingBean, DisposableBean
{

    private String url;

    public NetworkClient() {
        System.out.println("consturct = " + url);
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("message = " + message + " call = " + url);
    }

    public void disconnect() {
        System.out.println("disconnect = " + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("init message");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("init message");
    }

    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
}
