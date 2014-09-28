package nextnote;

import java.util.Date;

public class Note
{
    private String title;
    private String contents;
    private Date created;
    private Date updated;
    private String font;
    private int fontsize;
    private int categoryid = 0;

    public Note(String title, String contents, String font, int fontsize)
    {
        this.title = title;
        this.contents = contents;
        this.font = font;
        this.fontsize = fontsize;
        this.created = new Date();
        this.updated = new Date();
    }

    public Note(String title, String contents, String font, int fontsize,
            int categoryid)
    {
        this(title, contents, font, fontsize);
        this.categoryid = categoryid;
    }

    public String getTitle()
    {
        return title;
    }

    public String getContents()
    {
        return contents;
    }

    public Date getCreatedDate()
    {
        return created;
    }

    public Date getUpdatedDate()
    {
        return updated;
    }

    public String getFont()
    {
        return font;
    }

    public int getFontSize()
    {
        return fontsize;
    }

    public int getCategoryId()
    {
        return categoryid;
    }

    public void changeContents(String contents)
    {
        this.contents = contents;
    }

    public void changeTitle(String title)
    {
        this.title = title;
    }

    public void setFont(String font)
    {
        this.font = font;
    }

    public void setFontSize(int fontsize)
    {
        this.fontsize = fontsize;
    }

    public void setUpdatedDate(Date updated)
    {
        this.updated = updated;
    }

    public void setCategoryId(int categoryid)
    {
        this.categoryid = categoryid;
    }
}
