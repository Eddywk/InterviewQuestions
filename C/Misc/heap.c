/*
 * Max heapify implementation
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool is_not_heap(int root, int child) {
    if (root < child)
        return true;
    return false;
}

void swap(int a, int b, int *arr) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

void max_heapify(int i, int *arr, int arr_len) {
    /*
     * Find the largest element index
     * then swap and then heapify again
     * on the same largest index recursively
     */
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    int largest = i;

    if (l < arr_len && is_not_heap(arr[largest], arr[l]))
        largest = l;
    if (r < arr_len && is_not_heap(arr[largest], arr[r]))
        largest = r;

    if (i != largest) {
        swap(i, largest, arr);
        max_heapify(largest, arr, arr_len);
    }
}

void print_array(int *arr, int arr_len)
{
    int i;
    for (i = 0; i < arr_len; i++)
        printf("%d\t", arr[i], arr_len);
    printf("\n");
}

int main(int argc, char *argv[])
{
    int i = 0;
    int arr[] = { 1, 2, 3, 4, 5 };
    int arr_len = sizeof(arr) / sizeof(arr[0]);

    print_array(arr, arr_len);

    /*
     * Iterate the array from last root to
     * the top root
     */
    for (i = ((arr_len + 1)/2) - 1; i >= 0; i--)
        max_heapify(i, arr, arr_len);

    print_array(arr, arr_len);

    return 0;
}
