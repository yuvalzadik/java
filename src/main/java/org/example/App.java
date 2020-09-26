package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.net.httpserver.HttpPrincipal;
import com.sun.net.httpserver.HttpsParameters;


import javax.swing.text.html.HTML;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class App {

    private static final String POST_API_URL = "http://jsonplaceholder.typicode.com/";
    private static ObjectMapper mapper = new ObjectMapper(); // this object convert the json into java class



    // IOException -throws  if an I/O error occurs when sending or receiving
    // InterruptedException - throws if the operation is interrupted
    public static HttpResponse<String> getHttp (String url) throws IOException, InterruptedException { //create a function which get a url parameter and create a http response
        HttpClient client = HttpClient.newHttpClient(); //The http client
        HttpRequest request = HttpRequest.newBuilder() // Creating a http request
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POST_API_URL + url))
                .timeout(Duration.ofSeconds(2))
                .build();
        System.out.println("Sending request to /" + url);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // send thr request and get the response in string
        return response;

    }

    //create a function that returns the uncompleted tasks of a specific user
    public static UncompletedUser getUserUncompletedTasks (byte userid) throws IOException, InterruptedException {

        HttpResponse<String> response_tasks = getHttp("todos?userId=" + userid + "&completed=false"); // sending http request for getting the uncompleted task for each user
        List<Task> tasks = mapper.readValue(response_tasks.body(), new TypeReference<List<Task>>() {}); // creating a list which contains the response_tasks valu into a object from class Task


        UncompletedUser uncompleteduser = new UncompletedUser(); //creating a new object that contains userid with uncompleted tasks list
        uncompleteduser.setUserId(userid); // add the userid from the for loop user into the object UncompletedUser
        uncompleteduser.setTasks(tasks); // add the tasks list from http response tasks into the object UncompletedUser
        return uncompleteduser;
    }

    //create a function that returns the uncompleted tasks of all users
    public static PrimaryUsersList usersUncompletedTasks () throws IOException, InterruptedException {

        PrimaryUsersList primaryuncomletedusers = new PrimaryUsersList();
        List<UncompletedUser> listusers = new ArrayList<UncompletedUser>(); // creating a list named listusers which contains UncompletedUser type object


        HttpResponse<String> response_users = getHttp("users"); // calling the function getHttp with users url and return the response into response_users object.
        List<User> users = mapper.readValue(response_users.body(), new TypeReference<List<User>>() {}); // creating a list and map the response_users jason and convert into a java class

        for( User user : users){  //foreach user in users
            UncompletedUser uncompleteduser = getUserUncompletedTasks(user.getId());
            listusers.add(uncompleteduser); // after the UncompletedUser object is done we add it to the list of UncompletedUser users
        };

        primaryuncomletedusers.setUsers(listusers);
        return primaryuncomletedusers;
        

    }

    //create a function that returns all the comments of a specific post
    public static List<Comment> getComments (short postId) throws IOException, InterruptedException {
        HttpResponse<String> response_comments = getHttp("comments?postId=" + postId); // sending http request for getting the comments list for a specific postId
        List<Comment> comments = mapper.readValue(response_comments.body(), new TypeReference<List<Comment>>() {}); // creating a list which contains the response_comments value into a object from class Comment
        return comments;
    }

    //create a function that returns all the posts of a specific user
    public static List<Post> get_Posts (byte userId) throws IOException, InterruptedException {
        HttpResponse<String> response_posts = getHttp("posts?userId=" + userId); // sending http request for getting the posts list for a specific userId
        List<Post> posts = mapper.readValue(response_posts.body(), new TypeReference<List<Post>>() {}); // creating a list which contains the response_posts value into a object from class Post
        return posts;
    }

    //create a primary function that returns all emails per post per user.
    public static userPostReplierEmails getPostsReplierEmails () throws IOException, InterruptedException {
        userPostReplierEmails userpostReplierEmails = new userPostReplierEmails(); // create a primary object
        List<userPosts> listusers = new ArrayList<userPosts>(); // creating a list which contains a list of userPost objects


        HttpResponse<String> response_users = getHttp("users"); // calling the function getHttp with users url and return the response into response_users object.
        List<User> users = mapper.readValue(response_users.body(), new TypeReference<List<User>>() {}); // creating a list and map the response_users jason and convert into a java class
        //int i = 0;
        for( User user : users){//foreach user in users
            userPosts userposts = new userPosts(); // create a userpost object which contais a user id and post list 
//            if (i == 3){
//                break;
//            }
//            i++;
            List<Post> posts = get_Posts(user.getId()); // get all posts of a specific user
            List<PostEmails> postEmailslist = new ArrayList<PostEmails>(); // creating a list that contains post email object - post email object consists of post id and comment list
            
            for( Post post : posts) {  //foreach post in posts
                Thread.sleep(100);
                List<Comment> comments = getComments((short) post.getId()); // create a list of all comments for a specific port
                if (comments.isEmpty() == false) { // check if there is a comment on the post
                    PostEmails postemails = new PostEmails(); // create a new email_list in type PostEmail per post (contains post id and email list)
                    postemails.setEmails(comments); // add the comments - get only email 
                    postemails.setPostid(post.getId()); // add the post id
                    postEmailslist.add(postemails); /// insert the postemail object into the postEmailslist
                }
            }

            userposts.setPosts(postEmailslist); // insert list of posts ot the user
            userposts.setUserId(user.getId()); // add id to the user

            listusers.add(userposts);// after the user object is done we add it to the list of users
            System.out.println(listusers);

        };
        userpostReplierEmails.setUsersPosts(listusers); //inserting the list of uncompleted users to the final collection we  return to the user
//        System.out.println(primaryuncomletedusers);
        return userpostReplierEmails;
    }

 /*   //create a function that returns the uncompleted tasks of a specific user
    public static ddd getUse (byte userid) throws IOException, InterruptedException {

        HttpResponse<String> response_albums = getHttp("albums?userId=" + userid); // sending http request for getting the albumes for each user
        List<albums> albums = mapper.readValue(response_albums.body(), new TypeReference<List<albums>>() {}); // creating a list which contains the response_tasks value into a object from class album


        UncompletedUser uncompleteduser = new UncompletedUser(); //creating a new object that contains userid with uncompleted tasks list
        uncompleteduser.setUserId(userid); // add the userid from the for loop user into the object UncompletedUser
        uncompleteduser.setTasks(tasks); // add the tasks list from http response tasks into the object UncompletedUser
        return ddd;
    }*/

    //create a function that returns all the albums of a specific userId
    public static List<albums> getAlbums (byte userId) throws IOException, InterruptedException {
        HttpResponse<String> response_comments = getHttp("albums?userId=" + userId); // sending http request for getting the albums list for a specific userId
        List<albums> albums = mapper.readValue(response_comments.body(), new TypeReference<List<albums>>() {}); // creating a list which contains the response_comments value into a object from class Comment
        return albums;
    }

    //create a function that returns the photos of a specific album
    public static List<photos> getPhotos (byte albumId) throws IOException, InterruptedException {
        HttpResponse<String> response_comments = getHttp("photos?albumId=" + albumId); // sending http request for getting the albums list for a specific userId
        List<photos> photos = mapper.readValue(response_comments.body(), new TypeReference<List<photos>>() {}); // creating a list which contains the photos value
        return photos;
    }
    


    public static void main (String[]args ) throws IOException, InterruptedException {

        PrimaryUsersList primary = usersUncompletedTasks(); //calling the function to get the collection of users with uncompleted tasks

        //System.out.println(primary);

//        UncompletedUser user = getUserUncompletedTasks((byte) 1); //calling the function to get the collection of  a specific user - id 1 with uncompleted tasks
//        System.out.println(user);

        //covert into json
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(primary);
        System.out.println(json);

        /*userPostReplierEmails userpostemials = getPostsReplierEmails();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(userpostemials);
        System.out.println(json);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the nubmber ");
        int photo_input = myObj.nextInt();*/



    }



}
