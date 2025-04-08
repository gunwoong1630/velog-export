package com.velogexport.velogexport.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MDUtilsTest {
    @Test
    void should_extractImageUrls_when_giveMarkdown() {
        String markdown = """
                # 다익스트라 알고리즘
                                
                # 개념 소개
                                
                다익스트라 알고리즘은 **다이나믹 프로그래밍**을 이용한 **최단 경로 탐색 알고리즘**이다. 기존의 브루트 포스(완전 탐색 알고리즘)의 DFS 혹은 BFS와는 다르게 다익스트라 알고리즘이 다이나믹 프로그래밍에 속하는 이유는 최단 거리를 계산할 때 이전까지 구했던 최던 거리 정보를 사용한다는 점에서 다이나믹 프로그래밍의 메모이제이션(쉽게 이전 것을 활용하는 방법)을 사용한다.
                                
                # 알고리즘 원리
                                
                	1. 출발 노드 설정
                    2. 최단 거리 테이블 초기화
                    3. 방문하지 않은 노드 중 최단 거리가 가장 짧은 노드를 선택
                    4. 해당 노드의 근접 노드들로 가는 거리를 계산하여 최단 거리 테이블 갱신
                    5. 3번과 4번 반복
                   \s
                # 예시
                                
                ![](https://velog.velcdn.com/images/gwj0421/post/2eab9a6a-880b-4980-8c83-436f212217be/image.png)
                                
                위와 같은 네트워크가 형성되어 있을 때, 아래의 표와 같이 최단 거리 테이블이 만들어진다.
                                
                ![](https://velog.velcdn.com/images/gwj0421/post/1ad077b7-6d0c-4b33-8b7a-5b0c4fb49d39/image.png)
                                
                빨간색 글씨는 타겟 노드이고 노란색 글씨는 근접노드 및 방문이 필요한 노드이다. 검정색 글씨는 방문한 노드이다. 위의 순서대로 테이블을 최신화 하면서 마지막 최단 거리 테이블을 통해 시작 노드 A에서 다른 노드 B~E까지의 최단 거리를 알 수 있다.
                                
                # 예제 코드
                위의 원리 파트에서 3번에서 min함수를 사용하면 시간이 많이 걸릴 것이다. 대안으로 최소힙을 사용하면 간선의 개수를 E라 했을 때 시간 복잡도는 O(ElogE)가 될 것이다. 아래는 백준에서 문제 풀이시 사용했던 다익스트라 알고리즘 적용 부분을 가져온 것이다
                                
                ```
                def dijkstra(start):
                    timeTable = [sys.maxsize for _ in range(n + 1)]
                    timeTable[start] = 0
                    heap = []
                    heapq.heappush(heap, (0, start))
                    while heap:
                        nowTime, nowPosition = heapq.heappop(heap)
                        if timeTable[nowPosition] < nowTime:
                            print(nowPosition,timeTable,heap)
                            continue
                        for nextPosition, nextTime in graph[nowPosition]:
                            stand = nowTime + nextTime
                            if stand < timeTable[nextPosition]:
                                timeTable[nextPosition] = stand
                                heapq.heappush(heap, (stand, nextPosition))
                        print(nowPosition,timeTable,heap)
                    return timeTable
                ```
                                
                위의 코드에서 timeTable은 최단 거리 테이블로 생각하면 되고, 이 코드에서 아래의 부분의 의미는 힙을 사용할 때 이전에 방문했던 노드를 처리한다.\s
                                
                왜냐하면 힙을 사용할 때 근접 노드로 갈 때 여러 경로가 있을 경우 그 중 최단 경로를 선택하고 단순히 추가하기만 했지 전의 경로를 삭제하지는 않았다.\s
                                
                없어도 상관없는 코드이지만 효율을 높이고자 사용한다.
                                
                ```
                        if timeTable[nowPosition] < nowTime:
                            print(nowPosition,timeTable,heap)
                            continue
                ```
                                
                위의 내용을 직접 코드로 찍어보면 이해하기 쉽다. 아래의 결과는 예시 노드들과 위의 코드를 통해 진행했을 때 현재 위치와 최단 거리 테이블, 힙을 찍은 것이다.\s
                                
                ![](https://velog.velcdn.com/images/gwj0421/post/58e5ac98-5b49-4cba-be7d-a4b2d75246cd/image.png)
                                
                                
                ![](https://velog.velcdn.com/images/gwj0421/post/a382bf8e-332a-43df-88ab-f2dc3bc61097/image.png)
                                
                여기서 1번 노드를 기준으로 2, 3번 노드들이 최신화 되었고 2번 노드를 기준으로 3번 노드가 최신화 되었다. 하지만 힙에서는 (8,3)이 제거 되지 않았기 때문에 위의 코드처럼 작성되어야 4번 노드까지 진행했을 때 다시 근접노드를 탐색해야 하는 비효율을 줄일 수 있을 것이다.
                                
                # 알고리즘 문제 적용시 팁
                1. 보통 양방향보단 단방향으로 문제가 주어짐
                2. BFS와 DFS보단 시간 복잡도가 적어, 문제 풀이시 BFS와 DFS를 사용했을 때 시간초과가 발생한다면 다익스트라 알고리즘을 사용하면 좋음
                3. 특정 노드에서 다른 노드들로 가는 최단 경로를 구하는 문제에 사용
                """;

        // when
        List<String> result = MDUtils.extractImageUrls(markdown);

        // then
        assertThat(result).hasSize(4);
    }

}