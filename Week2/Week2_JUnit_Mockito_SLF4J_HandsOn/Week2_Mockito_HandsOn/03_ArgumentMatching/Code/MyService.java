public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void handle(String value) {
        api.process(value);
    }
}
