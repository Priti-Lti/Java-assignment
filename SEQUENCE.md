```sequenceDiagram
participant User
participant UserController
participant UserService
participant UserRepository
participant BlogPostController
participant BlogPostService
participant BlogPostRepository
participant CommentController
participant CommentService
participant CommentRepository

    User ->> UserController: POST /api/users/register
    UserController ->> UserService: registerUser(user)
    UserService ->> UserRepository: save(user)
    UserRepository ->> UserService: user
    UserService ->> UserController: user
    UserController ->> User: user

    User ->> UserController: POST /api/users/login
    UserController ->> UserService: findByUsername(username)
    UserService ->> UserRepository: findByUsername(username)
    UserRepository ->> UserService: user
    UserService ->> UserController: user
    UserController ->> User: "Login successful" or "Invalid username or password"

    User ->> BlogPostController: POST /api/blogposts
    BlogPostController ->> BlogPostService: createBlogPost(blogPost)
    BlogPostService ->> BlogPostRepository: save(blogPost)
    BlogPostRepository ->> BlogPostService: blogPost
    BlogPostService ->> BlogPostController: blogPost
    BlogPostController ->> User: blogPost

    User ->> BlogPostController: GET /api/blogposts
    BlogPostController ->> BlogPostService: getAllBlogPosts()
    BlogPostService ->> BlogPostRepository: findAll()
    BlogPostRepository ->> BlogPostService: List<BlogPost>
    BlogPostService ->> BlogPostController: List<BlogPost>
    BlogPostController ->> User: List<BlogPost>

    User ->> BlogPostController: GET /api/blogposts/my
    BlogPostController ->> BlogPostService: getBlogPostsByUser(user)
    BlogPostService ->> BlogPostRepository: findByUser(user)
    BlogPostRepository ->> BlogPostService: List<BlogPost>
    BlogPostService ->> BlogPostController: List<BlogPost>
    BlogPostController ->> User: List<BlogPost>

    User ->> CommentController: POST /api/comments
    CommentController ->> CommentService: createComment(comment)
    CommentService ->> CommentRepository: save(comment)
    CommentRepository ->> CommentService: comment
    CommentService ->> CommentController: comment
    CommentController ->> User: comment

    User ->> CommentController: GET /api/comments/blogpost/{blogPostId}
    CommentController ->> CommentService: getCommentsByBlogPost(blogPost)
    CommentService ->> CommentRepository: findByBlogPost(blogPost)
    CommentRepository ->> CommentService: List<Comment>
    CommentService ->> CommentController: List<Comment>
    CommentController ->> User: List<Comment
