package br.com.fiap.exercicio.entity;

import java.io.Serializable;

public class AlunoCoursePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private int aluno;
	
	private int nano;
	
	public AlunoCoursePK() {
		super();
	}

	public AlunoCoursePK(int aluno, int nano) {
		super();
		this.aluno = aluno;
		this.nano = nano;
	}
	
	public int getAluno() {
		return aluno;
	}

	public void setAluno(int aluno) {
		this.aluno = aluno;
	}

	public int getNano() {
		return nano;
	}

	public void setNano(int nano) {
		this.nano = nano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aluno;
		result = prime * result + nano;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoCoursePK other = (AlunoCoursePK) obj;
		if (aluno != other.aluno)
			return false;
		if (nano != other.nano)
			return false;
		return true;
	}
}