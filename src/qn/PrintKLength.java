package qn;

/*
    Print all possible strings of length k that can be formed from a set of n characters
    Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.

    Examples:

    Input:
    set[] = {'a', 'b'}, k = 3

    Output:
    aaa
    aab
    aba
    abb
    baa
    bab
    bba
    bbb
*/
public class PrintKLength {
    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};
        printAllPossible(set, "", set.length, 2);
    }
    static void printAllPossible(char[] set, String str, int n, int k){
        if (k == 0) {
            System.out.println(str);
            return;
        }
        for (int i = 0; i < n; i++){
            printAllPossible(set, str + set[i], n, k - 1);
        }
    }
}
