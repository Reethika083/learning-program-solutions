import React from "react";
import Post from "./Post";

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  loadPosts() {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => this.setState({ posts: data }))
      .catch((error) => {
        console.error("Error fetching posts:", error);
        throw error;
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred while rendering the posts.");
    console.error("Caught error:", error, info);
  }

  render() {
    return (
      <div>
        <h2>Blog Posts</h2>
        {this.state.posts.slice(0, 10).map((post) => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
