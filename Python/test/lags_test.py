import unittest

class SimpleTestCase(unittest.TestCase):

    def testA(self):
        """Test case A. note that all test method names must begin with 'test.'"""
        assert 2+2 == 4

if __name__ == "__main__":
    unittest.main()
