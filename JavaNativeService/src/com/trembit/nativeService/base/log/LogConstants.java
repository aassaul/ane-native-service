package com.trembit.nativeService.base.log;

/**
 * Created by Andrey Assaul on 04.07.2015.
 */
public final class LogConstants {
    public final static String TAG = "[Native Service]";

    public final static CommunicationMessage COMMUNICATION_MESSAGE = new CommunicationMessage();

    private LogConstants(){}

//    private void normalize(final Float[]a, float threshold){
//        Integer[] indexes = new Integer[a.length];
//        for (int i = 0; i<a.length; i++){
//            indexes[i] = i;
//        }
//        Comparator<Integer> indexesComparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer lhs, Integer rhs) {
//                return a[lhs].compareTo(a[rhs]);
//            }
//        };
//        Arrays.sort(indexes, indexesComparator);
//        int maxValueIndex = 0;
//        for (int i = 1; i < a.length; i++){
//            if (a[indexes[i]].equals(a[indexes[i-1]])){
//                maxValueIndex = i;
//            }else {
//                break;
//            }
//        }
//
//    }
}
