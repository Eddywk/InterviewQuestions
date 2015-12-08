#include <stdio.h>
#include <stdbool.h>

bool bs (int *arr, int arr_len, int s, int e, int lookup) {
    /*
     * Check if last is greater then arr_len or
     * also if the e is less then s.
     * Basic recursion check.
     * Complexity : log(n)
     * Reason: It halves the sample set every time.
     * log(8) base 2 = 3, i.e 3 steps to find.
     */
    if (e < s || e >= arr_len) return false;

    int m = (s + e) / 2;

    if (arr[m] == lookup) return true;
    if (arr[m] > lookup )
        return bs(arr, arr_len, s, m - 1, lookup);
    else
        return bs(arr, arr_len, m + 1, e, lookup);
}

int main (int argc, char *argv[])
{
    int arr[] = { 1, 3, 4, 5 };
    int arr_len = sizeof(arr) / sizeof(arr[0]);
    int lookup = 0;

    printf("Is %d present = %d\n", lookup, bs(arr, arr_len, 0, arr_len -1, lookup));
    return 0;
}
