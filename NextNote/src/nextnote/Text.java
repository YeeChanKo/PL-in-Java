package nextnote;

public class Text
{
    private String texts;
    private Boolean italic = false;
    String[] availableFonts = new String[] { "바탕", "바탕체", "돋움", "돋움체", "굴림",
            "굴림체", "궁서", "궁서체", "맑은고딕", "HY견고딕", "HY견명조", "HY신명조", "HY중고딕",
            "휴먼매직체", "휴먼편지체", "새굴림", "휴먼아미체", "휴먼옛체", "휴먼둥근헤드라인", "휴먼엑스포" };

    public String[] getFontList()
    {
        return availableFonts;
    }

    public void setTexts(String texts)
    {
        this.texts = texts;
    }

    public void setItalic(Boolean italic)
    {
        this.italic = italic;
    }

    public String getTexts()
    {
        return this.texts;
    }

    public Boolean getItalic()
    {
        return this.italic;
    }
}
