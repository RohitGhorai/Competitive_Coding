package tcs_ipa.IPA6;

import java.util.*;

public class IPA6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        RRT[] rrts = new RRT[4];
        for (int i = 0; i < 4; i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt(); sc.nextLine();
            String e = sc.nextLine();
            rrts[i] = new RRT(a, b, c, d, e);
        }
        String p = sc.nextLine();
        RRT res = getHighestPriorityTicket(rrts, p);
        if (res == null) System.out.println("No such ticket.");
        else System.out.println(res.getTicketNo() + "\n" + res.getRaisedBy() + "\n" + res.getAssignedTo());
    }
    static RRT getHighestPriorityTicket(RRT[] rrts, String project){
        RRT res = null;
        int priority = Integer.MAX_VALUE;
        for (RRT r : rrts)
            if (r.getProject().equals(project))
                if (priority > r.getPriority()) {
                    priority = r.getPriority();
                    res = r;
                }
        return res;
    }
}
class RRT {
    private int ticketNo, priority;
    private String raisedBy, assignedTo, project;
    public RRT(int no, String raisedBy, String assign, int priority, String project){
        this.ticketNo = no;
        this.raisedBy = raisedBy;
        this.assignedTo = assign;
        this.priority = priority;
        this.project = project;
    }
    public int getTicketNo(){
        return this.ticketNo;
    }
    public String getRaisedBy(){
        return this.raisedBy;
    }
    public String getAssignedTo(){
        return this.assignedTo;
    }
    public int getPriority(){
        return this.priority;
    }
    public String getProject(){
        return this.project;
    }
}