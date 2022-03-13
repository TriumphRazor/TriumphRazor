import os

print("Getting environments data from jenkins")

folder_name = os.getenv("folder")
file_name = os.getenv("filename")

print(f"Folder name :{folder_name}")
print(f"File name: {file_name}")
