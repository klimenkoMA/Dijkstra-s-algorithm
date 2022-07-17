package service;

import entity.DijkstraAlgoritm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.DijkstraAlgoritmRepository;

import java.util.List;

@Service
@ComponentScan(basePackageClasses = DijkstraAlgoritmRepository.class)
public class DijkstraAlgoritmService {
	@Autowired
	DijkstraAlgoritmRepository dijkstraAlgoritmRepository;

	public List<DijkstraAlgoritm> findAllVertex() {
		return dijkstraAlgoritmRepository.findAll();
	}

	public List<DijkstraAlgoritm> findVertexById(int id){
		return dijkstraAlgoritmRepository.findById(id);
	}

	public void deleteVertexById(int id){
		dijkstraAlgoritmRepository.deleteById(id);
	}

	public void addVertex(DijkstraAlgoritm dijkstraAlgoritm){
		dijkstraAlgoritmRepository.save(dijkstraAlgoritm);
	}

	int minDistance(int[] dist, Boolean[] sptSet) {
		// Инициализируем минимальное значение
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int i = 0; i < 6; i++)
			//Если вершина еще не пройдена и расстояние меньше последнего минимума
			if(!sptSet[i] && dist[i] <= min) {
				//устанавливаем новый минимум, сохраняем номер вершины
				min = dist[i];
				min_index = i;
			}
		return min_index;
	}

	public int[] dijkstra(int[][] graph, int src) {
		int[] dist = new int[6]; // Выходной массив. dist [i] будет держать
		// кратчайшее расстояние от источника до каждой вершины
		// sptSet [i] будет истинным, если вершина i включена в кратчайшее
		// дерево пути или кратчайшее расстояние от src до i завершено
		Boolean[] sptSet = new Boolean[6];

		// Инициализируем все расстояния как бесконечность (INFINITE), а stpSet[] как false
		for(int i = 0; i < 6; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Расстояние исходной вершины от себя всегда равно 0
		dist[src] = 0;

		// Находим кратчайший путь для всех вершин
		for(int count = 0; count < 6 - 1; count++) {

			// Выбираем минимальное расстояние вершины из множества вершин, еще не пройденных
			int u = minDistance(dist, sptSet);

			// Пометить выбранную вершину как пройденную
			sptSet[u] = true;

			// Обновляем значение dist соседних вершин
			// выбранная вершина.
			for(int i = 0; i < 6; i++) {
				//				System.out.println("---- " + dist[i] + " ----");
				// Обновляем dist [i], только если нет в sptSet, есть
				// ребро от u до i и общий вес пути от src до
				// i через u меньше текущего значения dist [i]
				if(!sptSet[i] && graph[u][i] != 0 &&
						dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i]) {
					dist[i] = dist[u] + graph[u][i];
				}
			}
		}
		// выводим построенный массив расстояний
		return dist;
	}
}
