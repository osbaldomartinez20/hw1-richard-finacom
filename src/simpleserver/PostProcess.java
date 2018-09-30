package simpleserver;

import com.google.gson.Gson;

public class PostProcess extends Processor implements DataInterface{
    private int postid;
    private int userid;
    private String post;

    public PostProcess() {
        this.post = "";
        this.postid = -1;
        this.userid = -1;
    }
    public PostProcess(int uID, int gPostId, String gPost){
        this.postid = gPostId;
        this.post = gPost;
        this.userid = uID;
    }

    public PostProcess(String request) {
        super(request);
    }

    public String process() {
        return null;
    }

    public int getId() {
        return postid;
    }

    public int getUserID() {return userid;}

    public String getData() {
        return post;
    }

    public String convertToJson() {
        return new Gson().toJson(this);
    }

}