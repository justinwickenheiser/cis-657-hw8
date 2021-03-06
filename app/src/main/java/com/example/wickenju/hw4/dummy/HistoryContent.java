package com.example.wickenju.hw4.dummy;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryContent {
    public static final List<HistoryItem> ITEMS = new ArrayList<HistoryItem>();
    public static void addItem(HistoryItem item) {
        ITEMS.add(item);
    }
    public static class HistoryItem {
        public final String origLat;
        public final String origLng;
        public final String destLat;
        public final String destLng;
        public final DateTime timestamp;
        public HistoryItem(String origLat, String origLng, String destLat, String destLng, DateTime timestamp) {
            this.origLat = origLat;
            this.origLng = origLng;
            this.destLat = destLat;
            this.destLng = destLng;
            this.timestamp = timestamp;
        }
        @Override
        public String toString() {
            return "(" + this.origLat + "," + this.origLat + ")";
        }
    }
    static {
        DateTime now = DateTime.now();
        addItem(new HistoryItem("43.12444", "-85.3523", "42.1234", "85.3555",
                now.minusDays(1)));
        addItem(new HistoryItem("42.12444", "-77.3523", "42.1234", "85.3555",
                now.minusDays(1)));
        addItem(new HistoryItem("43.12444", "-85.3523", "42.1234", "85.3555",
                now.plusDays(1)));
        addItem(new HistoryItem("55.12444", "-85.3523", "42.1234", "85.3555",
                now.plusDays(1)));
    }
}