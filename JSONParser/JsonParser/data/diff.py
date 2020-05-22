import sys

def Diff(f1, f2):
  file1 = open(f1)
  dict1 = {}

  file2 = open(f2)
  dict2 = {}

  for line in file1.readlines():
    if len(line) == 0:
      continue
    arr = line.strip().split(',', 1)
    if len(arr) < 2:
      continue
    dict1[arr[0]] = arr[1]

  for line in file2.readlines():
    if len(line) == 0:
      continue
    arr = line.strip().split(',', 1)
    if len(arr) < 2:
      continue
    dict2[arr[0]] = arr[1]

  print "stard file lines: %d" %(len(dict1))
  print "resul file lines: %d" %(len(dict2))

  if len(dict1) != len(dict2):
    return 0.0

  cnt = 0
  for (k,v) in dict1.items():
    if dict2.has_key(k) and dict2[k].strip().lower() == v.strip().lower():
      cnt += 1

  print "accurate count %d" %(cnt)

  if len(dict1) == 0:
    return 1.0
  else:
    return (cnt * 1.0)/len(dict1)


if __name__ == '__main__':
  if len(sys.argv) < 3 :
      print "Usage: ./exe file1 file2"
  else:
    print "accurate rate %.4f %%" %(Diff(sys.argv[1], sys.argv[2]) * 100)
