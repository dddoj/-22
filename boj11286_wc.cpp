#include <iostream>
#include <cstdio>
#include <cmath>

using namespace std;
int* heap;
int heapSize = 0;

void swap(int* arr1, int* arr2) {
	int tmp = *arr1;
	*arr1 = *arr2;
	*arr2 = tmp;
}

void push(int data) {
	//가장 끝에 데이터 넣음
	heap[++heapSize] = data;

	int child = heapSize;
	int parent = child / 2;
	while ((child > 1 && abs(heap[parent]) > abs(heap[child])) || ( (child > 1 && abs(heap[parent]) == abs(heap[child])) && heap[parent] > heap[child] ) ) {
		swap(&heap[parent], &heap[child]);
		child = parent;
		parent = child / 2;
	}
}

int pop() {
	//루트노드
	int res = heap[1];

	//printf("%d, %d, %d\n", heap[1], heap[2], heapSize);
	swap(&heap[1], &heap[heapSize]);
	//printf("%d, %d, %d\n", heap[1], heap[2], heapSize);
	heapSize--;

	int parent = 1;
	int child = parent * 2;
	if (child + 1 <= heapSize) {
		child = ((abs(heap[child]) < abs(heap[child + 1])) || ( (abs(heap[child]) == abs(heap[child + 1])) && (heap[child] < heap[child + 1]) ) ) ? child : child + 1;
	}

	while ( (child <= heapSize && abs(heap[parent]) > abs(heap[child])) || ( (child <= heapSize && ( abs(heap[parent]) == abs(heap[child]) )) && (heap[parent] > heap[child]) ) ) {
		swap(&heap[parent], &heap[child]);

		parent = child;
		child = child * 2;
		if (child + 1 <= heapSize) {
			child = ((abs(heap[child]) < abs(heap[child + 1])) || ((abs(heap[child]) == abs(heap[child + 1])) && (heap[child] < heap[child + 1]))) ? child : child + 1;
		}
	}
	return res;
}

int main() {
	int N;
	scanf("%d", &N);
	heap = new int[N];
	int input;
	for (int i = 0; i < N; i++) {
		scanf("%d",&input);
		if (input == 0) {//출력
			if (heapSize != 0)//힙사이즈가 0이면 
				printf("%d\n", pop());
			else
				printf("0\n");
		} else {//입력
			push(input);
		}
	}

	return 0;
}
