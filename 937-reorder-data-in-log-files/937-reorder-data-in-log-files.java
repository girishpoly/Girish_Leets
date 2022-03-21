class Solution {
    /*
      Grab all letter logs
      sort them by substring, or identifier
      then put all digit logs after
    */
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<String>(logs.length);
        List<String> digitLogs = new ArrayList<String>(logs.length);
        for(String log : logs)
          if(isLetterLog(log))
            letterLogs.add(log);
          else
            digitLogs.add(log);
        Collections.sort(letterLogs, (a,b) -> {
          String aLog = a.substring(a.indexOf(" "));
          String bLog = b.substring(b.indexOf(" "));
          if(aLog.equals(bLog))
            return a.compareTo(b);
          else
            return aLog.compareTo(bLog);
        });
      letterLogs.addAll(digitLogs);
      return letterLogs.toArray(new String[letterLogs.size()]);
    }
  
    private boolean isLetterLog(String log){
      return Character.isLetter(log.charAt(log.indexOf(" ")+1));
    }
}