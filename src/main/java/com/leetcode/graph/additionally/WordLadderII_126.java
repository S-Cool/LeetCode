package com.leetcode.graph.additionally;

import java.util.*;

//A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
//beginWord -> s1 -> s2 -> ... -> sk such that:
//
//        Every adjacent pair of words differs by a single letter.
//        Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//        sk == endWord
//        Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation
//        sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should
//        be returned as a list of the words [beginWord, s1, s2, ..., sk].
//
//        Example 1:
//        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//        Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//        Explanation: There are 2 shortest transformation sequences:
//        "hit" -> "hot" -> "dot" -> "dog" -> "cog"
//        "hit" -> "hot" -> "lot" -> "log" -> "cog"
//
//        Example 2:
//        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//        Output: []
//        Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

public class WordLadderII_126 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        System.out.println("Result: " + result);
    }

    /**
     *
     * Time complexity: O(N^2 * M + N^2) - N is the number of words and M is the length of each word
     * Space complexity: O(N * M) - space, where N is the number of words and M is the length of each word
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graphKeyAndNeighbors = fillGraphKeyListConnectedWords(beginWord, wordList);

        Queue<List<String>> queueBFS = new LinkedList<>();
        queueBFS.offer(new ArrayList<>(Arrays.asList(beginWord)));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        List<List<String>> result = new ArrayList<>();

        int barrier = Integer.MAX_VALUE;
        while (!queueBFS.isEmpty()) {
            printStack(queueBFS);
            System.out.println("");
            List<String> currentPath = queueBFS.poll();
            if (currentPath.size() > barrier) {
                break; //stop adding new "key paths" to our BFS queue upon discovering the shortest pat
            }

            if (currentPath.get(currentPath.size() - 1).equals(endWord)) {
                result.add(currentPath); // Find the shortest path and add it to result list
                barrier = currentPath.size(); // Set barrier (Optimization)
            }
            String last = currentPath.get(currentPath.size() - 1);
            List<String> neighbors = graphKeyAndNeighbors.get(last);
            for (String neighbor : neighbors) {
                if (!currentPath.contains(neighbor) && !visited.contains(neighbor)) { //verify if we visited this word before
                    ArrayList<String> currentPathPlusOnePossibleNeighbor = new ArrayList<>(currentPath);
                    currentPathPlusOnePossibleNeighbor.add(neighbor);
                    if (barrier > currentPathPlusOnePossibleNeighbor.size()) {
                        queueBFS.offer(currentPathPlusOnePossibleNeighbor);
                    }
                }
            }
            visited.add(currentPath.size() < 3 // Add to visited set the word which was visited
                    ? currentPath.get(currentPath.size() - 1) // If path contains less than two elements
                    : currentPath.get(currentPath.size() - 2)); // If path contains more than two elements
        }

        return result;
    }

    /**
     * Generate Graph Map
     *      hit -> hot
     *      hot -> dot, lot, hit
     *      dot -> hot, dog, lot
     *      lot -> hot, dot, log
     *      dog -> dot, log, cog
     *      log -> dog, lot, cog
     *      cog -> dog, log
     *
     * @param beginWord -
     * @param wordList
     * @return
     */
    private static Map<String, List<String>> fillGraphKeyListConnectedWords(String beginWord,
                                                                            List<String> wordList) {
        ArrayList<String> wordListWithBeginWord = new ArrayList<>(wordList);
        wordListWithBeginWord.add(beginWord);
        Map<String, List<String>> graphKeyAndNeighbors = new HashMap<>();
        for (String word : wordListWithBeginWord) {
            List<String> listOfWordsWithOnlyOneDifferentCharacter = new ArrayList<>();
            for (String wordTwo : wordListWithBeginWord) {
                if (isOnlyOneDifferentChar(word, wordTwo)) {
                    listOfWordsWithOnlyOneDifferentCharacter.add(wordTwo);
                }
            }
            graphKeyAndNeighbors.put(word, listOfWordsWithOnlyOneDifferentCharacter);
        }
        return graphKeyAndNeighbors;
    }

    /**
     * Verify if first word and second word have only one different letter
     *
     * @param word - first word
     * @param wordTwo - second word
     * @return return true if first and second word have only one different letter
     */
    private static boolean isOnlyOneDifferentChar(String word, String wordTwo) {
        if (word.length() != wordTwo.length()) {
            return false;
        }

        int different = 0;
        char[] chars = word.toCharArray();
        char[] charsTwo = wordTwo.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (chars[i] != charsTwo[i]) {
                different++;
            }
            if (different > 1) {
                return false;
            }
        }
        return different == 1;
    }

    private static void printStack(Queue<List<String>> stack) {
        System.out.println("");
        System.out.println("STACK SIZE: " + stack.size());
        System.out.println("--------------------");
        for (List<String> list : stack) {
            for (String str : list) {
                System.out.print("" + str + ", ");
            }
            System.out.println("");
        }
    }
}
