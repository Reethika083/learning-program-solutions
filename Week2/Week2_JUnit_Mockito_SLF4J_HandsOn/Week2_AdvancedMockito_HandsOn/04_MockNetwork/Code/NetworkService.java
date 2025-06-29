public class NetworkService {
    private NetworkClient client;

    public NetworkService(NetworkClient client) {
        this.client = client;
    }

    public String connectToServer() {
        String response = client.connect();
        return "Connected to " + response;
    }
}
