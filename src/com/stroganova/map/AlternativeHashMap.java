package com.stroganova.map;

public class AlternativeHashMap {
        /*
        @Override
        public void putAll(Map map) {
            ArrayList mapEntries = map.entryList();
            for (Object obj : mapEntries) {
                Entry entry = (Entry) obj;
                put(entry.key, entry.value);
            }
        }
    */

        /*        @Override
        public void putAllIfAbsent (Map map){
            ArrayList mapEntries = map.entryList();
            for (Object obj : mapEntries) {
                Entry entry = (Entry) obj;
                putIfAbsent(entry.key, entry.value);
            }
        }*/



/*    ArrayList entryList();*/

/*    public ArrayList entryList() {
        ArrayList entries = new ArrayList();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                ArrayList innerBucket = buckets[i];
                for (Object obj : innerBucket) {
                    Entry entry = (Entry) obj;
                    entries.add(entry);
                }
            }
        }
        return entries;
    }*/

}
