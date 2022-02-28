import java.util.ArrayList;

public class Diary {
    private String ownerName;
    private ArrayList<Gist> gist = new ArrayList<>(); // the array list needed to be initialised so that it can take entries.
    private ArrayList<Gist> favGist = new ArrayList<>();
    private String password;

    public Diary(String name, String key) {
        ownerName = name;
        password = key;
    }

    public ArrayList<Gist> getFavGist() {
        return favGist;
    }

    public void setFavGist(ArrayList<Gist> favGist) {
        this.favGist = favGist;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public ArrayList<Gist> getGist() {
        return gist;
    }

    public void setGist(ArrayList<Gist> gist) {
        this.gist = gist;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasssword() {
        return password;
    }

    public void addNewGist(String title, String story, String key) {
        if (key.equals(password)) {
            Gist myGist = new Gist(title, story);
            gist.add(myGist);
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    public Gist findGistByTitle(String gistTitle) {
        for (Gist myGist : gist) {
            if (myGist.getTitle().equalsIgnoreCase(gistTitle))
                return myGist;
        }

        throw new IllegalArgumentException("Gist not found");

    }

    public void deleteAnyGist(String title, String key) {
        if (key.equals(password)) {
            for (Gist myGist : gist)
                if (myGist.getTitle().equalsIgnoreCase(title))
                    gist.remove(myGist);
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    public Gist viewAllGist() {
        for (Gist allGist : gist) {
            return allGist;
        }
        throw new IllegalArgumentException("invalid argument");
    }

    public void markAsFavoriteGist(String title) {
            for (Gist myGist : gist){
                if (myGist.getTitle().equalsIgnoreCase(title)) {
                    favGist.add(myGist);
                }
                else {
                    throw new IllegalArgumentException("Gist not found");
            }

            }
        }

}
