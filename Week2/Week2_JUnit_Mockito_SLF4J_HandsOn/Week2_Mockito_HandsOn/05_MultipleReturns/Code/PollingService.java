public class PollingService {
    private ExternalApi api;

    public PollingService(ExternalApi api) {
        this.api = api;
    }

    public String pollTwice() {
        String first = api.getData();
        String second = api.getData();
        return first + " | " + second;
    }
}
