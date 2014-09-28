package nextnote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//*핵심: 읽기 좋은 코드 짜기!

class NextNote
{
    int noteCounter = 1;
    int categoryCounter = 1;
    Map<Integer, Note> noteBook = new HashMap<Integer, Note>();
    Map<Integer, Category> categoryBook = new HashMap<Integer, Category>();

    // 노트 부분

    void createNote(String title, String contents, String font, int fontsize)
    {
        Note newnote = new Note(title, contents, font, fontsize);
        addNote(newnote);
    }

    void createNote(String title, String contents, String font, int fontsize,
            String category)
    {
        int categoryid = checkAndCreateCategory(category);
        Note newnote = new Note(title, contents, font, fontsize, categoryid);
        addNote(newnote);
    }

    void addNote(Note note)
    {
        noteBook.put(noteCounter, note);
        noteCounter++;
    }

    void modifyNote(int targetId, String title, String contents, String font,
            int fontsize, String category)
    {
        Note targetNote = findNote(targetId);
        targetNote.changeTitle(title);
        targetNote.changeContents(contents);
        targetNote.setFont(font);
        targetNote.setFontSize(fontsize);
        targetNote.setUpdatedDate(new Date());
        targetNote.setCategoryId(checkAndCreateCategory(category));
    }

    void modifyNoteFont(int targetId, String font, int fontsize)
    {
        Note targetNote = findNote(targetId);
        targetNote.setFont(font);
        targetNote.setFontSize(fontsize);
        targetNote.setUpdatedDate(new Date());
    }

    String viewNoteList()
    {
        String result = "";
        for (int key : noteBook.keySet())
        {
            result += key + "\t" + noteBook.get(key).getTitle() + "\t\t\t\t"
                    + noteBook.get(key).getCreatedDate() + "\n";
        }
        return result;
    }

    String viewNote(int targetId)
    {
        String result = "";
        Note targetNote = findNote(targetId);

        String resultTitle = "제목:\t\t" + targetNote.getTitle();
        String resultCategory = "카테고리:\t"
                + categoryBook.get(targetNote.getCategoryId()).getCategory();
        String resultCreated = "생성날짜:\t" + targetNote.getCreatedDate();
        String resultUpdated = "수정날짜:\t" + targetNote.getUpdatedDate();
        String resultContents = "내용:\t\t" + targetNote.getContents();
        String resultFont = "폰트:\t\t" + targetNote.getFont();
        String resultFontSize = "폰트 사이즈:\t" + targetNote.getFontSize();

        result = resultTitle + "\n" + resultCategory + "\n" + resultCreated
                + "\n" + resultUpdated + "\n" + resultContents + "\n"
                + resultFont + "\n" + resultFontSize + "\n";
        return result;
    }

    void removeNote(int targetId)
    {
        noteBook.remove(targetId);
    }

    Note findNote(int targetId)
    {
        return noteBook.get(targetId);
    }

    // 카테고리 부분

    void initCategory()
    {
        categoryBook.put(0, new Category());
    }

    void createCategory(String category)
    {
        Category cate = new Category(category);
        addCategory(cate);
    }

    void addCategory(Category cate)
    {
        categoryBook.put(categoryCounter, cate);
        categoryCounter++;
    }

    void modifyCategory(int targetId, String category)
    {
        Category targetCate = findCategory(targetId);
        targetCate.setCategory(category);
    }

    String viewCategoryList()
    {
        String result = "";
        for (int key : categoryBook.keySet())
        {
            result += key + "\t" + categoryBook.get(key).getCategory() + "\n";
        }
        return result;
    }

    void removeCategory(int targetId)
    {
        for (int key : noteBook.keySet())
        {
            if (key == targetId)
            {
                setDefaultCategory(key);
            }
        }
        categoryBook.remove(targetId);
    }

    Category findCategory(int targetId)
    {
        return categoryBook.get(targetId);
    }

    int checkAndCreateCategory(String category) // String값 존재할시 해당 키값 반환, 없으면
                                                // 카테고리 생성 후 새로운 키값 반환
    {
        int result = -1;
        for (int key : categoryBook.keySet())
        {
            if (categoryBook.get(key).getCategory() == category)
            {
                result = key;
                break;
            }
        }
        if (result == -1)
        {
            result = categoryCounter;
            createCategory(category);
        }
        return result;
    }

    void setDefaultCategory(int targetId)
    {
        noteBook.get(targetId).setCategoryId(0);
    }
}
