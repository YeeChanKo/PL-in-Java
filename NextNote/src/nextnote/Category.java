package nextnote;

public class Category
{
    String category;

    Category()
    {
        this.category = "카테고리 없음";
    }

    Category(String category)
    {
        this.category = category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return this.category;
    }
}
