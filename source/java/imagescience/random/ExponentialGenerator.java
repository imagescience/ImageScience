package imagescience.random;

import java.lang.Math;

/** Exponential random number generator. This implementation is based on taking the natural logarithm of uniform random numbers, the latter of which are obtained from class {@link UniformGenerator}. For more details, see for example W. H. Press, S. A. Teukolsky, W. T. Vetterling, B. P. Flannery, <a href="http://numerical.recipes/" target="_blank">Numerical Recipes in C: The Art of Scientific Computing</a> (2nd edition), Cambridge University Press, Cambridge, 1992, Section 7.2. */
public class ExponentialGenerator implements RandomGenerator {
	
	private final double lambda;
	
	private final UniformGenerator unigen;
	
	/** Constructs a generator of random numbers from the exponential distribution with unit value at {@code 0} and initialized with a random seed. */
	public ExponentialGenerator() { this(1.0); }
	
	/** Constructs a generator of random numbers from the exponential distribution with unit value at {@code 0} and initialized with the given {@code seed}.
		
		@param seed The seed used for initialization of the generator.
	*/
	public ExponentialGenerator(final int seed) { this(1.0,seed); }
	
	/** Constructs a generator of random numbers from the exponential distribution with value {@code lambda} at {@code 0} and initialized with a random seed.
		
		@param lambda The lambda parameter of the exponential distribution. Must be larger than {@code 0}.
		
		@throws IllegalArgumentException If {@code lambda} is less than or equal to {@code 0}.
	*/
	public ExponentialGenerator(final double lambda) {
		
		if (lambda <= 0.0) throw new IllegalArgumentException("Lambda less than or equal to 0");
		
		this.lambda = lambda;
		
		unigen = new UniformGenerator();
	}
	
	/** Constructs a generator of random numbers from the exponential distribution with value {@code lambda} at {@code 0} and initialized with the given {@code seed}.
		
		@param lambda The lambda parameter of the exponential distribution. Must be larger than {@code 0}.
		
		@param seed The seed used for initialization of the generator.
		
		@throws IllegalArgumentException If {@code lambda} is less than or equal to {@code 0}.
	*/
	public ExponentialGenerator(final double lambda, final int seed) {
		
		if (lambda <= 0.0) throw new IllegalArgumentException("Lambda less than or equal to 0");
		
		this.lambda = lambda;
		
		unigen = new UniformGenerator(seed);
	}
	
	/** Returns a random number from the exponential distribution with lambda specified at construction.
		
		@return A random number from the exponential distribution with lambda specified at construction.
	*/
	public double next() {
		
		return -Math.log(unigen.next())/lambda;
	}
	
/** Returns a random number from the exponential distribution with given {@code lambda}.
		
		@param lambda The lambda parameter of the exponential distribution. Must be larger than {@code 0}.
		
		@return A random number from the exponential distribution with given {@code lambda}.
		
		@throws IllegalArgumentException If {@code lambda} is less than or equal to {@code 0}.
	*/
	public double next(final double lambda) {
		
		if (lambda <= 0.0) throw new IllegalArgumentException("Lambda less than or equal to 0");
		
		return -Math.log(unigen.next())/lambda;
	}
	
}
