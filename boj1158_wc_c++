#pragma warning(disable:4996)
#include <cstdio>
#include <iostream>
#include <cstdlib>

using namespace std;

//리스트 구현
class Node {
public:
	int data;
	Node* next;
};

//리스트 헤드
Node* first;

int N;

void addLinkedList(int val) {
	Node* newNode = (Node*)(malloc(sizeof(Node)));

	newNode->data = val;
	newNode->next = NULL;

	if (first == NULL)
	{
		first = newNode;
		return;
	}

	Node* cur = first->next;
	Node* prev = first;
	
	//마지막 원소 찾기
	while (cur != NULL) {
		prev = cur;
		cur = prev->next;
	}
	prev->next = newNode;

	//마지막 입력값이 들어오면 노드가 first를 가르키도록 설정
	if (val == N) {
		newNode->next = first;
	}
}

int main() {
	int K;
	first = NULL;
	scanf("%d %d", &N, &K);
	for (int i = 1; i <= N; i++) {
		addLinkedList(i);
	}

	int cnt = 0;
	int equalK = 0;
	Node* cur = first;
	printf("<");

	//모든 수가 다 제거될때까지 루프 돔
	while (cnt != N-1) {
		while (equalK != K) {
			if (cur->data != 0) {
				equalK++;
			}
			if (equalK == K) {//3번째 찾아서 프린트해줌
				printf("%d, ",cur->data);
				cur->data = 0;
				cnt++;
				equalK = 0;
				break;
			}
			cur = cur->next;
		}
	}
	
	//마지막 수 출력
	while (true) {
		if (cur->data != 0) {
			printf("%d>", cur->data);
			break;
		}
		cur = cur->next;
	}
	return 0;
}
