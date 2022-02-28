import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
    Diary diary;
    @BeforeEach
    public void setDiaryUp() {
        diary = new Diary("dami", "dammyjay5");
    }
    @Test
    public void diaryCanBeCreatedTest(){
        assertNotNull(diary);
        assertEquals("dami", diary.getOwnerName());
    }
    @Test
    public void passwordCanBeSet(){
        diary.setPassword("deejay");
        assertEquals("deejay", diary.getPasssword());
    }

    @Test
    public void diaryCanAddGistTest(){
        diary.addNewGist("My last Hangout ", "I met a beautiful lady...", "dammyjay5");
        assertEquals(1, diary.getGist().size());
    }

    @Test
    public void viewGistByTitle(){
        diary.addNewGist("My last Hangout ", "I met a beautiful lady...", "dammyjay5");
        diary.addNewGist("My Semicolon experience", "My journey to tech and software engineering..", "dammyjay5");
        diary.addNewGist("My Hostel", "Today, as i entered the ...", "dammyjay5");

        Gist foundGist = diary.findGistByTitle("My Hostel");
        assertEquals("My Hostel", foundGist.getTitle());
        assertEquals("Today, as i entered the ...", foundGist.getGist());
        System.out.println(foundGist);
    }

    @Test
    public void canDeleteGist(){
        //given that there are gist that has been added
        diary.addNewGist("My last Hangout ", "I met a beautiful lady...", "dammyjay5");
        diary.addNewGist("My Semicolon experience", "My journey to tech and software engineering..", "dammyjay5");
        diary.addNewGist("My Hostel", "Today, as i entered the ...", "dammyjay5");
        assertEquals(3, diary.getGist().size());
        // check that you can delete one gist with title and password
        diary.deleteAnyGist("My Semicolon experience", "dammyjay5");
        //assert that 2 gists are left
        assertEquals(2, diary.getGist().size());
    }

    @Test
    public void viewAllGist(){
        //given that all the gist have been added
        diary.addNewGist("My last Hangout ", "I met a beautiful lady...", "dammyjay5");
        diary.addNewGist("My Semicolon experience", "My journey to tech and software engineering..", "dammyjay5");
        diary.addNewGist("My Hostel", "Today, as i entered the ...", "dammyjay5");
        assertEquals(3, diary.getGist().size());
        Gist viewAll = diary.viewAllGist();
        assertEquals(viewAll, diary.getGist());
    }

    @Test
    public void markFavoriteGist(){
        diary.addNewGist("My last Hangout", "I met a beautiful lady...", "dammyjay5");
        diary.addNewGist("My Semicolon experience", "My journey to tech and software engineering..", "dammyjay5");
        diary.addNewGist("My Hostel", "Today, as i entered the ...", "dammyjay5");
        assertEquals(3, diary.getGist().size());
        diary.markAsFavoriteGist("My Semicolon experience");
        assertEquals(1, diary.getFavGist().size());

    }

}