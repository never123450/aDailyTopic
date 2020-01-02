package four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @description:  业务上有个排序，commissionA 存的 nextMissionNo是 commissionB的 MissionNo
 *                              commissionB 存的 nextMissionNo是 commissionC的 MissionNo
 *                              commissionC 存的 nextMissionNo是 commissionD的 MissionNo
 *                              ........
 *                              依次循环
 *
 *                              有个List存放了所有的commission 而且是无序的，现需要将他们有序的显示
 *
 *                              已知A是第一个
 *
 * @author: xwy
 *
 * @create: 7:25 AM 2019/12/14
**/

public class SortMissionList {

    public static void main(String[] args) {


        Set<Mission> missions = new HashSet<Mission>();
        Mission missionA = new Mission();
        missionA.setCur("A");
        missionA.setNext("B");
        missions.add(missionA);

        Mission missionB = new Mission();
        missionB.setCur("B");
        missionB.setNext("C");
        missionB.setPre("A");
        missions.add(missionB);


        Mission missionD = new Mission();
        missionD.setCur("D");
        missionD.setNext("");
        missionD.setPre("C");
        missions.add(missionD);

        Mission missionC = new Mission();
        missionC.setCur("C");
        missionC.setNext("D");
        missionC.setPre("B");
        missions.add(missionC);

        System.out.println(missions);


        List<Mission> missionList = sortMissions(missions, missionA);


        System.out.println(missionList);

    }

    // 非递归
    private static List<Mission> sortMissions(Set<Mission> missions, Mission missionA) {
        List<Mission> missionList = new ArrayList<Mission>();
        missionList.add(missionA);
        String nextMissionNo = missionA.getNext();
        while(nextMissionNo!=null && !"".equals(nextMissionNo)) {
            for(Mission mission : missions) {
                if(nextMissionNo.equals(mission.getCur())) {
                    missionList.add(mission);
                    nextMissionNo = mission.getNext();
                    break;
                }
            }
        }
        return missionList;
    }

    // 递归方式
    private static List<Mission> sortMissionByrecursion(Set<Mission> missions, Mission missionA) {
        List<Mission> missionList = new ArrayList<Mission>();
        missionList.add(missionA);
        String next = missionA.getNext();

        return missionList;
    }


    static class Mission{
        private String pre;
        private String next;
        private String cur;

        public String getPre() {
            return pre;
        }

        public void setPre(String pre) {
            this.pre = pre;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getCur() {
            return cur;
        }

        public void setCur(String cur) {
            this.cur = cur;
        }

        @Override
        public String toString() {
            return "Mission [cur=" + cur + ", next=" + next + ", pre=" + pre + "]";
        }

    }
}