package com.example.rss.model;

import java.io.Serializable;

/**
 * This class is an represents a Feed Item.
 * It is used as a DataHolder.
 */
public class FeedItem implements Serializable
{
	private static final long serialVersionUID = 1709487133434245708L;
	
	private int id;
	private boolean read_state;
	private boolean starred_state;
	private String title;
    private String description;
    private String link;
    private String feedId;
    private String author;

    public FeedItem()
    {
        this("", "", "", "", "");
    }

    public FeedItem(String title, String description, String link, String feedId, String author)
    {
        this.title = title;
        this.description = description;
        this.link = link;
        this.feedId = feedId;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "FeedItem: [Title:" + this.title + ", Author:" + this.author
                + ", Description:" + this.description + ", Link:" + this.link
                + ", FeedId:" + this.feedId + "]";
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isRead_state() {
		return read_state;
	}

	public void setRead_state(boolean read_state) {
		this.read_state = read_state;
	}

	public boolean isStarred_state() {
		return starred_state;
	}

	public void setStarred_state(boolean starred_state) {
		this.starred_state = starred_state;
	}
}