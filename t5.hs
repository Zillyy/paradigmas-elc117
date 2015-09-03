--1
addSuffix :: String -> [String] -> [String]
addSuffix suffix str = [x ++ suffix | x <- str]