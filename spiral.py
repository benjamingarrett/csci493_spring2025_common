def spiral(arr):
  rows = len(arr)
  cols = len(arr[0])
  k = 0
  i = 0
  j = 0
  first_col = 0
  first_row = 1
  last_col = cols - 1
  last_row = rows - 1
  direction = 'right'
  acc = []
  while k < rows*cols:
    if direction == 'right':
      while j <= last_col:
        acc.append(arr[i][j])
        k += 1
        j += 1
      direction = 'down'
      last_col -= 1
      j -= 1
      i += 1
    if direction == 'down':
      while i <= last_row:
        acc.append(arr[i][j])
        k += 1
        i += 1
      direction = 'left'
      last_row -= 1
      i -= 1
      j -= 1
    if direction == 'left':
      while j >= first_col:
        acc.append(arr[i][j])
        k += 1
        j -= 1
      direction = 'up'
      first_col += 1
      j += 1
      i -= 1
    if direction == 'up':
      while i >= first_row:
        acc.append(arr[i][j])
        k += 1
        i -= 1
      direction = 'right'
      first_row += 1
      i += 1
      j += 1
  return acc

a = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
print(f'{spiral(a)}')
