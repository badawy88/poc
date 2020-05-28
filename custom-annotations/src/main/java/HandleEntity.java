import annotation.Entity;
import org.mangosdk.spi.ProviderFor;

@ProviderFor(Handler.class)
public class HandleEntity extends Handler<Entity>{
    @Override
    public void handle() {
        System.out.println("welcome");
    }
}
