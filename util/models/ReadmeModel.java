package util.models;

public class ReadmeModel {

    private int start;

    private int end;

    private StringBuilder contents;

    public ReadmeModel(int start, int end, StringBuilder contents) {
        this.start = start;
        this.end = end;
        this.contents = contents;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public StringBuilder getContents() {
        return contents;
    }

    public void setContents(StringBuilder contents) {
        this.contents = contents;
    }
}
