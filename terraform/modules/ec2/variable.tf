variable "instance_type" {
  type    = string
  default = "t2.micro"
}

variable "aws_ami_owner" {
  type = string
  default = "099720109477"
}

variable "author_name" {
  type = string
}

variable "private_key_path" {
  type = string
}

variable "sg_name" {
  type = string
}

variable "availability_zone" {
  type = string
}

variable "public_ip" {
  type = string
}

variable "main_directory" {
  type = string
}