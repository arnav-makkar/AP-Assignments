public class Course {
    public String name;
    public String code;
    public String prof;
    public String timings;
    public int credits;
    public int semester;
    public String pre_req;
    public String misc_info;

    public int grade;

    public Course(String name, String code, String prof, String timings, int semester, int Credits) {
        this.name = name;
        this.code = code;
        this.prof = prof;
        this.timings = timings;
        this.credits = Credits;
        this.semester = semester;
        this.pre_req = null;
        this.misc_info = null;
    }

    @Override
    public String toString() {
        return name;
    }
}
/*
class IP extends Course{
    public IP() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem1.add(this);
    }
}

class DC extends Course{
    public DC() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem1.add(this);
    }
}

class LA extends Course{
    public LA() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem1.add(this);
    }
}

class HCI extends Course{
    public HCI() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem1.add(this);
    }
}

class COM extends Course{
    public COM() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem1.add(this);
    }
}

 */

/*
class DSA extends Course{
    public DSA() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem2.add(this);
    }
}

class PnS extends Course{
    public PnS() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem2.add(this);
    }
}

class BE extends Course{
    public BE() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem2.add(this);
    }
}

class CO extends Course{
    public CO() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem2.add(this);
    }
}

class MnB extends Course{
    public MnB() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem2.add(this);
    }
}

class CTRSS extends Course{
    public CTRSS() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem2.add(this);
    }
}

class AP extends Course{
    public AP() {
        super("Advanced Programming", "CSE201", "Dr. Arun Balaji", "3:00pm-4:30pm on Monday and Wednesday");
        Data.sem3.add(this);
    }
}

class OS extends Course{
    public OS() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem3.add(this);
    }
}

class M3 extends Course{
    public M3() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem3.add(this);
    }
}

class DM extends Course{
    public DM() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem3.add(this);
    }
}

class NT extends Course{
    public NT() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem3.add(this);
    }
}

class SPP extends Course{
    public SPP() {
        super("Social and Political Philosophy", "SSH221", "Dr. Manohar Kumar", "4:30pm-6:00pm on Monday and Wednesday");
        Data.sem3.add(this);
    }
}

class PASSP extends Course{
    public PASSP() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem3.add(this);
    }
}

class PDE extends Course{
    public PDE() {
        super("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30:am on Tuesday and Thursday");
        Data.sem3.add(this);
    }
}

 */