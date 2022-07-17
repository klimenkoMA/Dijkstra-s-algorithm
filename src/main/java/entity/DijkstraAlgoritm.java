package entity;

import javax.persistence.*;

@Entity
@Table(name = "dijkstra")
public class DijkstraAlgoritm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "A")
	private int vertexA;
	@Column(name = "B")
	private int vertexB;
	@Column(name = "C")
	private int vertexC;
	@Column(name = "D")
	private int vertexD;
	@Column(name = "E")
	private int vertexE;
	@Column(name = "F")
	private int vertexF;
	@Column(name = "startVertex")
	private int startVertex;

	public DijkstraAlgoritm() {
	}


	public DijkstraAlgoritm(int id, int vertexA, int vertexB,
	                        int vertexC, int vertexD, int vertexE,
	                        int vertexF) {
		this.id = id;
		this.vertexA = vertexA;
		this.vertexB = vertexB;
		this.vertexC = vertexC;
		this.vertexD = vertexD;
		this.vertexE = vertexE;
		this.vertexF = vertexF;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVertexA() {
		return vertexA;
	}

	public void setVertexA(int vertexA) {
		this.vertexA = vertexA;
	}

	public int getVertexB() {
		return vertexB;
	}

	public void setVertexB(int vertexB) {
		this.vertexB = vertexB;
	}

	public int getVertexC() {
		return vertexC;
	}

	public void setVertexC(int vertexC) {
		this.vertexC = vertexC;
	}

	public int getVertexD() {
		return vertexD;
	}

	public void setVertexD(int vertexD) {
		this.vertexD = vertexD;
	}

	public int getVertexE() {
		return vertexE;
	}

	public void setVertexE(int vertexE) {
		this.vertexE = vertexE;
	}

	public int getVertexF() {
		return vertexF;
	}

	public void setVertexF(int vertexF) {
		this.vertexF = vertexF;
	}

	public int getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(int startVertex) {
		this.startVertex = startVertex;
	}
}
