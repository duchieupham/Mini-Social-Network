/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msocial.dtos;

import java.io.Serializable;

/**
 *
 * @author phamduchieu
 */
public class EmotionDTO implements Serializable {

    private int emotionID;
    private int postID;
    private boolean like;
    private String createdDate;
    private String emailID;
    private String status;

    public EmotionDTO() {
    }

    public int getEmotionID() {
        return emotionID;
    }

    public void setEmotionID(int emotionID) {
        this.emotionID = emotionID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean isLike) {
        this.like = isLike;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
