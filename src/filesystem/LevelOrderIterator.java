package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import structures.Node;
import structures.Queue;



/**
 * An iterator to perform a level order traversal of part of a filesystem. A
 * level-order traversal is equivalent to a breadth- first search.
 * 
 * @author liberato
 *
 */
public class LevelOrderIterator extends FileIterator<File> {
	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * 
	 * @param rootNode
	 * @throws FileNotFoundException
	 *             if the rootNode does not exist
	 */
	private Queue<File> toIter = new Queue<File>();

	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		if (!rootNode.exists()) {
			throw new FileNotFoundException("File does not exist");
		} else {
			toIter.enqueue(rootNode);
		}
	}

	@Override
	public boolean hasNext() {
		if (toIter.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public File next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException("No files to iterate through");
		} else {
			if (toIter.get(0).isDirectory()){
				File[] temp = toIter.peek().listFiles();
				for (int i = 0; i < temp.length; i++){
					toIter.enqueue(temp[i]);
				}
			}
			
			return toIter.dequeue();
		}
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();
	}

}
