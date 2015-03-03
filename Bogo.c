#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void swap(int *a, int *b) {

  int temp = *a;
  *a = *b;
  *b = temp;
}

void randomize(int arr[], int n) {

  srand(time(NULL));
  for (int i = n - 1; i > 0; i--) {

    int j = rand() % (i + 1);
    swap(&arr[i], &arr[j]);
  }
}

_Bool isSortd(int arr[], int n) {

  for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++) {

      if (arr[i] > arr[j]) {

	return 1;
      }
    }
  }

  return 0;
}

void printArray(int arr[], int n) {

  printf("{");
  for (int i = 0; i < n; i++) {
   
    printf("%d", arr[i]);
    if (i != (n - 1))
      printf(",");
  }
  printf("}");
}

int main() {

  int bogousArray[] = { 1, 5, 2, 9, 3 };
  int counts = 0;

  while (isSortd(bogousArray, 5)) {

    randomize(bogousArray, 5);
    counts++;

    if (counts % 1000 == 0) {
     
      printArray(bogousArray, 5);
      printf(" -- On pass: %d\n", counts);
    }
  }
}
