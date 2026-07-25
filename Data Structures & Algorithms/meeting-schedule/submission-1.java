/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
     boolean ans[]=new boolean [1000002];
     for(Interval p:intervals){
         for(int i=p.start; i<p.end;i++){
            if(ans[i]==true) return false;
            ans[i]=true;
         }
     }
     return true;
    }
}
