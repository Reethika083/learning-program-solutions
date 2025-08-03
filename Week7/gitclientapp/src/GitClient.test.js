import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {
  test("should return repository names for techiesyed", async () => {
    const mockRepos = [
      { name: "repo1" },
      { name: "repo2" },
      { name: "repo3" },
    ];

    axios.get.mockResolvedValue({ data: mockRepos });

    const repos = await GitClient.getRepositories("techiesyed");
    expect(repos).toEqual(["repo1", "repo2", "repo3"]);
  });
});
