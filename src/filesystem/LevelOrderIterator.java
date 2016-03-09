package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import structures.Node;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem. A level-order traversal is equivalent to a breadth-
 * first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {	
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	private Node<File> root;
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		if (rootNode == null){
			throw new FileNotFoundException("File does not exist");
		}
		else{
			root = new Node<File>(rootNode, null);
		}
	}
	
	@Override
	public boolean hasNext() {
		if (root.getNext() != null){
			return true;
		}
		return false;
	}

	@Override
	public File next() throws NoSuchElementException {
		if (root == null){
			throw new NoSuchElementException("No files to iterate through");
		}
		else{
			File temp = root.getData();
			root = root.getNext();
			return temp;
		}
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
