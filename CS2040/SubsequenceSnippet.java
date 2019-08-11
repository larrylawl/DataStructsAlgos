String original = "ABCDE";
ArrayList<String> subsequences = new ArrayList<>();

subsequences.add(""); // Initialization

for (char c : original.toCharArray()) {
    int size = subsequences.size();
    // Take an existing subsequence and append the 
    // current character to form a new subsequence.
    for (int i = 0; i < size; ++i) {
        subsequences.add(subsequences.get(i) + c);
    }
}